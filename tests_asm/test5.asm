push 0
push 4
push -2
lfp
add
lw
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
push 3
lhp
sw
push 1
lhp
add
shp
push 3
push -2
lfp
add
lw
push -3
lfp
add
lw
label10:
push 0
lhp
push -1
add
bleq label11
lhp
push -1
add
lw
push -3
lfp
add
lw
beq label9
lhp
lhp
push -2
add
lw
sub
shp
b label10
label9:
lhp
label11:
push fChild
lw
js
halt

fParent:
cfp
lra
push 1
lfp
add
lw
srv
sra
pop
pop
pop
sfp
lrv
lra
js

fChild:
cfp
lra
push 2
push 1
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
