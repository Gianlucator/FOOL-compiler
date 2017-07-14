push 0
push 4
push -2
lfp
add
lw
lhp
push 0
add
sw
push Child
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
push -3
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
print
halt

f1Parent6:
cfp
lra
push 2
push 2
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

r1Parent6:
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
sfp
lrv
lra
lro
sop
js

Parent:
lmo
push 0
beq f1Parent6
lmo
push 1
beq r1Parent6

f1Child5:
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
sfp
lrv
lra
lro
sop
js

r1Child5:
cfp
lra
push 3
push 1
lfp
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
lro
sop
js

Child:
lmo
push 0
beq f1Child5
lmo
push 1
beq r1Child5
halt
