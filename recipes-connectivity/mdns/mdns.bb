SUMMARY = "Apple MDNS responder"
SECTION = "applications"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI  = "git://github.com/gera-k/mDNSResponder.git;rev=master "
SRC_URI[md5sum] = "59e148cf6e5afacc8c2ceb532782f1be"
SRC_URI[sha256sum] = "7b39e35de027b7ff0803666af2265367bf1ec5dd294d39915c0eb250cbb4abc4"

S = "${WORKDIR}/git/mDNSResponder-878.1.1/mDNSPosix"

FILES_${PN} += "/usr/bin /usr/sbin ${sysconfdir} /usr/lib /usr/include"
FILES_${PN}-dbg += "/usr/sbin/.debug"

PACKAGES = "${PN}-dbg ${PN}"

do_compile() {
    ${MAKE} -C ${S} os=linux
}

INITSCRIPT_PARAMS = "defaults 52"
INITSCRIPT_NAME = "mdns"

inherit autotools update-rc.d

do_install() {
    install -d ${D}/usr/sbin
    install -m 0755 ${S}/build/prod/mdnsd ${D}/usr/sbin

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/mdnsd.sh ${D}${sysconfdir}/init.d/mdns

    install -d ${D}/usr/lib
    install -m 0755 ${S}/build/prod/libdns_sd.so ${D}/usr/lib

    install -d ${D}/usr/include
    install -m 0755 ${S}/../mDNSShared/dns_sd.h ${D}/usr/include

    install -d ${D}/usr/bin
    install -m 0755 ${S}/../Clients/build/dns-sd ${D}/usr/bin
}
