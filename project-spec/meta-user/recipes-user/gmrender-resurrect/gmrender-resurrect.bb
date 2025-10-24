SUMMARY = "GMediaRenderer Resurrect - DLNA renderer for Linux using GStreamer"
DESCRIPTION = "A DLNA/UPnP audio renderer built on top of GStreamer."
HOMEPAGE = "https://github.com/hzeller/gmrender-resurrect"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=4325afd396febcb659c36b49533135d4"

SRC_URI = "git://github.com/hzeller/gmrender-resurrect.git;branch=master;protocol=https"
SRCREV = "ce6504c35f613dbc3470d1f20faab88be20bd9ff"

S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good libupnp libtool glib-2.0 alsa-lib"

inherit autotools pkgconfig update-rc.d

do_install() {
    oe_runmake install DESTDIR=${D}

    # Install SysV init script
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/scripts/init.d/gmediarenderer ${D}${sysconfdir}/init.d/gmediarenderer
}

# Register SysV init service
INITSCRIPT_NAME = "gmediarenderer"
INITSCRIPT_PARAMS = "defaults 95 10"

FILES:${PN} += " \
	${sysconfdir}/init.d/gmediarenderer \
	${datadir}/gmediarender \
"

RDEPENDS:${PN} += "gstreamer1.0 gstreamer1.0-plugins-base"

