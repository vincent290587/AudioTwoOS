SUMMARY = "Custom WAV sound files"
DESCRIPTION = "Installs .wav files into the root filesystem"
LICENSE = "CLOSED"

SRC_URI = " \
    file://16_192k_PerfectTest.wav \
    file://16_44k_PerfectTest.wav \
    file://16_48k_PerfectTest.wav \
    file://24_192k_PerfectTest.wav \
    file://24_48k_PerfectTest.wav \
    file://24_96k_PerfectTest.wav \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/share/sounds/mdac
    install -m 0644 ${WORKDIR}/*.wav ${D}/usr/share/sounds/mdac/
}

FILES_${PN} += "/usr/share/sounds/mdac"
