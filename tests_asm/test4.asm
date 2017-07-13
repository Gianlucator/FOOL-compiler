push 0
push 1
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
push B
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
push B
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
