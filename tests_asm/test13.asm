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
push 11
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

getAB:
cfp
lra
push -3
lop
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

getBB:
cfp
lra
push -4
lop
add
lw
srv
sra
pop
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
lw
push -3
lfp
lw
add
lw
js
srv
sra
pop
sfp
lrv
lra
js
