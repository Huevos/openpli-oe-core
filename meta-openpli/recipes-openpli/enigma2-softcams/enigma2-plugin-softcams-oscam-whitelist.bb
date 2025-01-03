DESCRIPTION = "OsCam iCam whitelist"
MAINTAINER = "AbuBaniaz"
LICENSE = "CLOSED"

PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"

SRC_ORIGIN ?= "git://github.com/E2OpenPlugins/oscam-whitelist.git;protocol=https;branch=main"
SRC_URI := "${SRC_ORIGIN} "

S = "${WORKDIR}/git"

DEPENDS = "enigma2-plugin-softcams-oscam"

inherit allarch

do_install () {
	install -d ${D}${sysconfdir}/enigma2/
	if [ -e ${S}/whitelist_streamrelay ]; then
		rm -f ${S}/whitelist_streamrelay
	fi
	cp -r ${S}/whitelist_streamrelay ${D}${sysconfdir}/enigma2
}
