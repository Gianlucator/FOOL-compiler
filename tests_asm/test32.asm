push 0
push B
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
add
shp
lhp
push A
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
lhp
push 2
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
print
halt

aparam6B1:
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

B:
lmo
push 0
beq aparam6B1

b1A1:
cfp
lra
push 2
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
beq b1A1
halt
