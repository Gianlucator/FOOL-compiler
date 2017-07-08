push 0
push function1
lfp
lfp
push -2
lfp
add
lw
js
push -3
lfp
add
lw
sop
lfp
lfp
push getNumNumero
js
print
halt

getNumNumero:
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

function1:
cfp
lra
push 1
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
push 20
lhp
sw
push 1
lhp
add
shp
lhp
srv
sra
pop
sfp
lrv
lra
js
