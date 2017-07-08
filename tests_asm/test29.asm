push 0
push 8
lhp
sw
push 1
lhp
add
shp
push 3
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
push getThis7Numero6
js
push -3
lfp
add
lw
sop
lfp
lfp
push getX4Numero6
js
print
halt

getThis7Numero6:
cfp
lra
lop
srv
sra
pop
sfp
lrv
lra
js

getX4Numero6:
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
halt
