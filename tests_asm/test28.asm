push 0
push 2
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
push 2
lhp
sw
push 1
lhp
add
shp
lhp
lhp
sw
push 1
lhp
add
shp
push 10
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
push 1
lhp
sw
push 1
lhp
add
shp
lhp
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
push 4
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
push getA4B1
js
push -2
lfp
add
lw
sop
lfp
lfp
push value5A1
js
push -3
lfp
add
lw
sop
lfp
lfp
push value5A1
js
add
print
halt

value5A1:
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

getA4B1:
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
