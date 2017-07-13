push 0
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
push B
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

f1A1:
cfp
lra
push 1
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
beq f1A1

f1B1:
cfp
lra
push 3
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
beq f1B1
halt
