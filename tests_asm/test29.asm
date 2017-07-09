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
push 4
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
push getC4B1
js
print
halt

getA4A1:
cfp
lra
push -2
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

getB4A1:
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

getC4B1:
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
halt
