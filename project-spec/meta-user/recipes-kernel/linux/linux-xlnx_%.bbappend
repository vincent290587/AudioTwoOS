FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://bsp.cfg"
KERNEL_FEATURES:append = " bsp.cfg"

SRC_URI:append = " file://xlnx_spdif_user.c"

do_configure:append() {
    cp ${WORKDIR}/xlnx_spdif_user.c ${S}/sound/soc/xilinx/xlnx_spdif.c
}
