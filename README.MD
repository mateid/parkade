#About *parkade*

This was a little experiment I put together a little while ago and it went nowhere. The idea was to provide machine readable parking zone information so that you can scan a QR code on the parking sign with your phone and know if you can park there or not at that time without having to decipher the often cryptic information on the sign itself. This would be particularly useful when dealing with a cluster of signs all displaying seemingly contradictory information - we've all been there.

Anyway this didn't really go anywhere but I think it's a good example of integrating with a barcode scanning app in your project. Here I used [Barcode Scanner](https://github.com/zxing/zxing/wiki/Frequently-Asked-Questions) which is a great open source option for scanning all types of bar codes.

You'd be scanning someting similar to this (notice the QR code on the parking sign):
![Parking signs](/graphics/signs.jpg)

I apologize for the image quality, this is someting I put together quickly and printed so I can demo the application workflow.

What you'd see on your phone once you scanned the code would be something like this:
![Parking information decoded](/graphics/parkingok.png)
