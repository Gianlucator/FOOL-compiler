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
push 0
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
push calcAreaRectangle89
js
print
halt

areaRectangle49:
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

getL1Rectangle59:
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

getL2Rectangle59:
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

scaleAreaRectangle99:
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

calcAreaRectangle89:
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
