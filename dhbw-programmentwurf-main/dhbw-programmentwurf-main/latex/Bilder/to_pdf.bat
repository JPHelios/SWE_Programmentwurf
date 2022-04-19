echo "Konvertiere PDF Dateien"
for %%f in (*.svg) do (
    python remove_watermark.py "%%~nf.svg"
    "C:\Program Files\Inkscape\bin\inkscape" -D "%%~nf.svg" -o "%%~nf.pdf"
)