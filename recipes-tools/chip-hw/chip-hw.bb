SUMMARY = "C.H.I.P Hardware explorer"
SECTION = "applications"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=7ae2be7fb1637141840314b51970a9f7"

SRC_URI  = "git://github.com/gera-k/chip-hw.git;rev=master "

S = "${WORKDIR}/git"

do_compile() {
    ${MAKE} -C ${S}/Release
}

do_install() {
    install -d ${D}/usr/bin
    install -m 0755 ${S}/Release/chip_hw ${D}/usr/bin

    install -d ${D}/usr/include
    install -m 0755 ${S}/src/chip_hw.h ${D}/usr/include
}
