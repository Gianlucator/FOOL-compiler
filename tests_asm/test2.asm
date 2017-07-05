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
push -1169699505
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
shp
push areaRectangle
lw
js
print
halt

areaRectangle:
cfp
lra
push -3
lfp
lw
add
lw
push -4
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
