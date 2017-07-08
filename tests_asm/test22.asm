push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 0
lhp
sw
push 1
lhp
add
shp
lhp
push 2
lhp
sw
push 1
lhp
add
shp
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
push s1Area4
js
push -3
lfp
add
lw
sop
lfp
lfp
push t1Rectangle9
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
halt
