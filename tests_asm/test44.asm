push 0
push 1
lhp
push 0
add
sw
push A
lhp
push 1
add
sw
push 3
lhp
push 2
add
sw
lhp
push 3
add
shp
lhp
lop
sro
push -2
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
lop
sro
push -3
lfp
add
lw
sop
lfp
lfp
push 2
smo
lop
push -2
add
lw
js
print
halt

createB7A1:
cfp
lra
push 2
lhp
push 0
add
sw
push -3
lop
add
lw
lhp
push 1
add
sw
push B
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
add
shp
lhp
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
beq createB7A1

getX4B1:
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

getY4B1:
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
lro
sop
js

B:
lmo
push 0
beq createB7A1
lmo
push 1
beq getX4B1
lmo
push 2
beq getY4B1
halt
