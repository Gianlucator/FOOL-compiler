push 0
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
