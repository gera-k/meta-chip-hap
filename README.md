# meta-chip-hap
HAP meta layer for NextThingCo C.H.I.P. Yocto

Based on meta-chip-example-wifi https://github.com/myfreescalewebpage/meta-chip-examples

Requires meta-chip layer https://github.com/myfreescalewebpage/meta-chip

## Using

* Clone the meta-chip and the meta-chip-hap layers
* Edit WiFi credentials in the [wpa_supplicant.conf](https://github.com/gera-k/meta-chip-hap/blob/master/recipes-connectivity/wpa-supplicant/files/wpa_supplicant.conf-sane)
* Build the __chip-image-hap__ image. Refer to [myfreescalewebpage](https://github.com/myfreescalewebpage) repos for build instructions.
* Flash the image to C.H.I.P board.
* Poweron the board. If WiFi credential are correct, it will connect to your WiFi and start the Hap server.
* Open Home app on your Apple device and connect to the RedLed accessory. 
