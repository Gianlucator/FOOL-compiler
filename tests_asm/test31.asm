push 0
push function0
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
push getNum6Numero27
js
print
halt

getNum6Numero6:
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

getNum6Numero27:
cfp
lra
push -2
lop
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

function0:
cfp
lra
push 1
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
srv
sra
pop
sfp
lrv
lra
js
halt
