SUMMARY = "HomeKit Accessory Protocol Server"
SECTION = "applications"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=b97bfb277a1a4e5cdea3ef95576b5b9e"

SRC_URI  = "git://github.com/gera-k/hap.git;rev=master \
            file://hap"

S = "${WORKDIR}/git"

DEPENDS = "mdns"
RDEPENDS_${PN} = "mdns"

INITSCRIPT_PARAMS = "defaults 85"
INITSCRIPT_NAME = "hap"

inherit autotools update-rc.d

do_compile() {
    ${MAKE} -C ${S}/Linux/Release
}

do_install() {
    install -d ${D}/usr/bin
    install -m 0755 ${S}/Linux/Release/HapLinux ${D}/usr/bin

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/hap ${D}${sysconfdir}/init.d

}
