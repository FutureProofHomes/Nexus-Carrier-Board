# `Darknet` edge AI demo

`darknet-edgeai-demo` is an object detection demo using `darknet` and `ImGui`.
YOLOv4 is used as an inference model, and is implemented in the [darknet](https://github.com/AlexeyAB/darknet) framework.
Inference is run in a separate thread, which allows for smooth display from a video or camera, while objects are being detected.

Details regarding the demo can be found in the project’s [README.md](https://github.com/antmicro/darknet-imgui-visualization/blob/master/README.md).

## How to use

You can fetch all the necessary code with:
```
mkdir darknet-demo && cd darknet-demo
repo init -u https://github.com/antmicro/meta-antmicro.git -m demos/darknet-edgeai-demo/manifest.xml
repo sync -j`nproc`
```

To start building the BSP, run the following commands:
```
source sources/poky/oe-init-build-env
MACHINE="jetson-xavier-nx-devkit-emmc" bitbake darknet-edgeai-demo
```

When the build process is complete, the resulting image will be stored in `build/tmp/deploy/images/jetson-xavier-nx-devkit-emmc` directory.

Board flashing process requires [PyYAML](https://pypi.org/project/PyYAML/) package to be pre-installed.
It can be done using:
```
sudo pip install PyYAML
```
We can unpack the tegraflash package, and then flash the board by putting the hardware in recovery mode, run the following commands:
```
cd tmp/deploy/images/jetson-xavier-nx-devkit-emmc
mkdir flash-directory && cd flash-directory
tar xzvf ../darknet-edgeai-demo-jetson-xavier-nx-devkit-emmc.tegraflash.tar.gz
sudo ./doflash
```

After a successful flashing, the board should boot up and a darknet visualization demo should start automatically.
