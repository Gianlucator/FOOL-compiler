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
push areaRectangle
lw
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
