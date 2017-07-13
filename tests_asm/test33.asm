push 0
push 1
lhp
sw
push 1
lhp
add
shp
lhp
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
push 0
smo
push Area
js
push -3
lfp
add
lw
sop
lfp
lfp
push 0
smo
push Rectangle
js
add
print
halt

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
js

Area:
lmo
push 0
beq s1Area4

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
js

Rectangle:
lmo
push 0
beq t1Rectangle9
halt
