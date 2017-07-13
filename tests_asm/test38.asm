push 0
push 5
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
push A
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
push -3
lop
add
lw
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
mult
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

afun4A1:
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
beq afun4A1
halt
