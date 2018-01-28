DESCRIPTION = "CHIP image WiFi/HAP, to demonstrate Homekit Protocol daemon"
LICENSE = "MIT"

require recipes-core/images/chip-image-minimal.bb

IMAGE_INSTALL += " \
  chip-packagegroup-wifi \
  libstdc++ \
  mc \
  ldd \
  openssh \
  mdns \
  chip-hw \
"
