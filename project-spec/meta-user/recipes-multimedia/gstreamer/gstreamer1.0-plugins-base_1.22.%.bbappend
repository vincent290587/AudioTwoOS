
# Force-enable ALSA plugin support in GStreamer Base Plugins
PACKAGECONFIG:append = " alsa"

# Optional — make absolutely sure Meson is told explicitly
EXTRA_OEMESON += " -Dalsa=enabled "
