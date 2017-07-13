push 0
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
push -2
lfp
add
lw
sop
lfp
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

get3A1:
cfp
lra
push 44
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
beq get3A1

get3B1:
cfp
lra
push 555
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
beq get3B1

ooo3C1:
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
js

C:
lmo
push 0
beq ooo3C1
halt
