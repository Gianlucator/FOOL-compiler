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
push -2
lfp
add
lw
label1:
push 0
lhp
push -1
add
bleq label2
lhp
push -1
add
lw
push -2
lfp
add
lw
beq label0
lhp
lhp
push -2
add
lw
sub
shp
b label1
label0:
lhp
label2:
push areaRectangle
lw
js
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