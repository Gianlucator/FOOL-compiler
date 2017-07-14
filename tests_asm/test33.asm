push 0
push Area
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
push Rectangle
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

t1Rectangle9:
cfp
lra
push 2
srv
sra
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
beq t1Rectangle9

s1Area4:
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

Area:
lmo
push 0
beq s1Area4
halt
