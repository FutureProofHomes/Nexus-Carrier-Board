DESCRIPTION = "Resize data partition to fill remaining space"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "data-resizefs.service"
FILES:${PN} += " \
    ${base_sbindir}/data-resizefs \
    ${systemd_unitdir}/system/data-resizefs.service \
"

SRC_URI = " \
    file://data-resizefs.service \
    file://data-resizefs.sh.in \
"

RDEPENDS:${PN} += " \
    bash \
    parted \
    e2fsprogs-resize2fs \
    util-linux-findmnt \
"

do_compile() {
    sed -e 's:@@RDFM_DATA_PART@@:${RDFM_PARTITION_DATAFS}:' ${WORKDIR}/data-resizefs.sh.in > ${WORKDIR}/data-resizefs.sh
}

do_install() {
    install -d ${D}/${base_sbindir}
    install -m 0744 ${WORKDIR}/data-resizefs.sh ${D}/${base_sbindir}/data-resizefs
    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/data-resizefs.service ${D}/${systemd_unitdir}/system
}
