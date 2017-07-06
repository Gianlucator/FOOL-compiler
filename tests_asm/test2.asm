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
push 0
push 2
push -2
lfp
add
lw
push areaRectangle
lw
js
push -3
lfp
add
lw
add
print
halt

areaRectangle:
cfp
lra
push -1
lfp
lw
add
lw
push -2
lfp
lw
add
lw
mult
srv
sra
pop
pop
sfp
lrv
lra
js
