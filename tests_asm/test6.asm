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
push 2
lhp
sw
push 1
lhp
add
shp
lhp
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
push Child
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
js

Child:
lmo
push 0
beq f1Child5
lmo
push 1
beq r1Child5
halt
