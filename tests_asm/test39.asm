push 0
push 3
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
push 5
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
push 2
smo
lop
push -2
add
lw
js
print
halt

getA4A1:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
sfp
lrv
lra
lro
sop
js

getB4A1:
cfp
lra
push -4
lop
add
lw
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
beq getA4A1
lmo
push 1
beq getB4A1

getter6B1:
cfp
lra
lop
sro
lfp
lfp
push 1
smo
lop
push -2
add
lw
js
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
beq getA4A1
lmo
push 1
beq getB4A1
lmo
push 2
beq getter6B1
halt
