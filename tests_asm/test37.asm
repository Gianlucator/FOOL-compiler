push 0
push 4
lhp
push 0
add
sw
push 2
lhp
push 1
add
sw
push Rectangle
lhp
push 2
add
sw
push 4
lhp
push 3
add
sw
lhp
push 4
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
push 5
push 3
lfp
push 4
smo
lop
push -2
add
lw
js
print
halt

area4Rectangle9:
cfp
lra
push -3
lop
add
lw
push -4
lop
add
lw
mult
srv
sra
pop
sfp
lrv
lra
lro
sop
js

getL15Rectangle9:
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

getL25Rectangle9:
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

scaleArea9Rectangle9:
cfp
lra
push 1
lfp
add
lw
push -3
lop
add
lw
push -4
lop
add
lw
mult
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

calcArea8Rectangle9:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
lro
sop
js

Rectangle:
lmo
push 0
beq area4Rectangle9
lmo
push 1
beq getL15Rectangle9
lmo
push 2
beq getL25Rectangle9
lmo
push 3
beq scaleArea9Rectangle9
lmo
push 4
beq calcArea8Rectangle9
halt
