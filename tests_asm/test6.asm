push 0
push 4
lhp
sw
push 1
lhp
add
shp
push 2
lhp
sw
push 1
lhp
add
shp
push 4
lhp
sw
push 1
lhp
add
shp
push 13
lhp
sw
push 1
lhp
add
shp
lhp
push -2
lfp
add
lw
sop
lfp
push 5
push 3
lfp
push calcAreaRectangle
js
print
halt

areaRectangle:
cfp
lra
push -3
lop
add
lw
push -4
lop
add
lw
mult
srv
sra
pop
sfp
lrv
lra
js

getL1Rectangle:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js

getL2Rectangle:
cfp
lra
push -4
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js

scaleAreaRectangle:
cfp
lra
push 1
lfp
add
lw
push -3
lop
add
lw
push -4
lop
add
lw
mult
mult
srv
sra
pop
pop
sfp
lrv
lra
js

calcAreaRectangle:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js
