push 0
push 1
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
push -2
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
push -3
lfp
add
lw
sop
lfp
lfp
push 2
smo
push B
js
print
halt

createB7A1:
cfp
lra
push 2
lhp
sw
push 1
lhp
add
shp
push -2
lop
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
lhp
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
beq createB7A1

getX4B1:
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

getY4B1:
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
