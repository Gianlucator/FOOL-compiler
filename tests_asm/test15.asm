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
push 0
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
push getterB61
js
print
halt

getAA41:
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

getBA41:
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

getterB61:
cfp
lra
lfp
lfp
push getBA41
js
srv
sra
pop
sfp
lrv
lra
js
