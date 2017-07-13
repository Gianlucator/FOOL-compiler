push 0
push 3
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
lhp
push 7
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
lhp
push 1
lhp
sw
push 1
lhp
add
shp
lhp
push -4
lfp
add
lw
sop
lfp
push -2
lfp
add
lw
lfp
push 0
smo
push C
js
push -4
lfp
add
lw
sop
lfp
push -3
lfp
add
lw
lfp
push 0
smo
push C
js
add
print
halt

get3C1:
cfp
lra
push 1
lfp
add
lw
sop
lfp
lfp
push 0
smo
push A
js
srv
sra
pop
pop
sfp
lrv
lra
js

C:
lmo
push 0
beq get3C1

getX4A1:
cfp
lra
push -2
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

A:
lmo
push 0
beq getX4A1

B:
lmo
push 0
beq getX4A1
halt
