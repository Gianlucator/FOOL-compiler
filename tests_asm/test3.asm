push 0
push 7
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
push 1
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
push 8
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
push getCB
js
print
halt

getAA:
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
js

getBA:
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
js

getCB:
cfp
lra
push -5
lop
add
lw
srv
sra
pop
sfp
lrv
lra
js
