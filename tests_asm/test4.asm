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
push 1
smo
lop
push -2
add
lw
js
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
add
print
halt

u1A1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

k1A1:
cfp
lra
push 5
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
lmo
push 1
beq k1A1

u1B1:
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

k1B1:
cfp
lra
push 6
srv
sra
pop
sfp
lrv
lra
js

s1B1:
cfp
lra
push 3
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
beq u1B1
lmo
push 1
beq k1B1
lmo
push 2
beq s1B1
halt
