#!/bin/sh

imageFile=$1
width=$(tput cols)
height=$(tput lines)

build/install/imageRenderer/bin/imageRenderer $imageFile $width $height
