push 0
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push get3B1
js
print
halt

function0:
cfp
lra
push 5
srv
sra
pop
pop
sfp
lrv
lra
js

get3B1:
cfp
lra
push function0
lfp
lop
lfp
push -2
lfp
add
lw
js
srv
pop
sra
pop
sfp
lrv
lra
js
halt
