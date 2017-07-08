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
push getter6B1
js
print
halt

getA4A1:
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

getB4A1:
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

getter6B1:
cfp
lra
lfp
lfp
push getB4A1
js
srv
sra
pop
sfp
lrv
lra
js
halt
