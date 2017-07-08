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
push 5
lhp
sw
push 1
lhp
add
shp
push 21
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
push getterB
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

getterB:
cfp
lra
lfp
lfp
push getBA
js
srv
sra
pop
sfp
lrv
lra
js
