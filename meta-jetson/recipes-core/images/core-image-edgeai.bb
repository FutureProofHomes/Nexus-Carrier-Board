DESCRIPTION = "Edge AI demos base image"

IMAGE_FEATURES_append = " \
    package-management \
    ssh-server-openssh \
    tools-debug \
    x11 \
    x11-base \
"

REQUIRED_DISTRO_FEATURES = "x11"

LICENSE = "Apache-2.0" 

inherit core-image features_check

IMAGE_INSTALL_append = " \
    cudnn \
    glfw \
    htop \
    nano \
    opencv \
    openssh \
    rsync \
    sudo \
    vim \
    x11vnc \
    xdotool \
    packagegroup-xfce-base \
"
