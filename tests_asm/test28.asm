push 0
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
print
halt

u1A1:
cfp
lra
push 1
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
beq u1A1

s1B1:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js

B:
lmo
push 0
beq u1A1
lmo
push 1
beq s1B1
halt
