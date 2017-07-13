push 0
push 3
lhp
sw
push 1
lhp
add
shp
push A
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
lhp
lhp
sop
push 7
lhp
sw
push 1
lhp
add
shp
push B
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
lhp
lhp
sop
push C
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
lhp
sop
lop
sro
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
lop
push -2
add
lw
js
lop
sro
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
lop
push -2
add
lw
js
add
print
halt

get3C1:
cfp
lra
lop
sro
push 1
lfp
add
lw
sop
lfp
lfp
push 0
smo
lop
push -2
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
lro
sop
js

C:
lmo
push 0
beq get3C1

getX4A1:
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
lro
sop
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
