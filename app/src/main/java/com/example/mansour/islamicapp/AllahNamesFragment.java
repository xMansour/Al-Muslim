package com.example.mansour.islamicapp;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Mansour on 8/13/2018.
 */

public class AllahNamesFragment extends Fragment {
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_allah_names, container, false);
        makeNamesListView();
        return mView;
    }

    private void makeNamesListView(){
        String [] allahNames ={"الله","الرحمن", "الرحيم" ,"الملك" , "القدوس", "السلام", "المؤمن", "المهيمن", "العزيز", "الجبار",
                "المتكبر", "الخالق", "البارئ", "المصور", "الغفار", "القاهر", "الوهاب", "الرزاق", "الفاتح",
                "العليم", "القابض", "الباسط", "الخافض", "الرافع", "المعز", "المذل", "السميع", "البصير",
                "الحكم", "العدل", "اللطيف", "الخبير", "الحليم", "العظيم", "الغفور", "الشكور", "العلى",
                "الكبير", "الحفيظ", "المقيت", "الحسيب", "الجليل", "الكريم", "الرقيب", "المجيب", "الواسع",
                "الحكيم", "الودود", "المجيد", "الباعث", "الشهيد", "الحق", "الوكيل", "القوى", "المتين",
                "الولى", "الحميد", "المحصى", "المبدئ", "المعيد", "المحيى", "المميت", "الحى", "القيوم",
                "الواجد", "الماجد", "الواحد", "الواحد", "الصمد", "القادر", "المقتدر", "المقدم", "المؤخر", "الأول",
                "الآخر", "الظاهر", "الباطن", "الوالى", "المتعال", "البر", "التواب", "المنتقم", "العفو",
                "الرؤوف", "المقسط", "الجامع", "الغنى", "المغنى", "المانع", "الضار", "النافع", "النور",
                "الهادى", "البديع", "الباقى", "الوارث", "الرشيد", "الصبور", "مالك الملك ذو الجلال والإكرام"};
        ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, allahNames);
        ListView listView = (ListView)mView.findViewById(R.id.listViewNames);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = String.valueOf(adapterView.getItemAtPosition(i));
                String description = "";
                //This switch statement should compare between the names and send a specific name and description to the showAlertDialog method.
                switch(name) {
                    case "الله":
                        description = "قال تعالى: وَهُوَ اللّهُ فِي السَّمَاوَاتِ وَفِي الأَرْضِ [الأنعام:3]\n" +
                                " فالله مشتق من أله يأله إلهة, فأصل الاسم الإله فحذفت الهمزة وأدغمت اللام الأولى في الثانية وجوبا فقيل: الله, ومن أقوى الأدلة عليه قوله تعالى: وَهُوَ اللّهُ فِي السَّمَاوَاتِ وَفِي الأَرْضِ [الأنعام: 3] مع قوله تعالى: وَهُوَ الَّذِي فِي السَّمَاءِ إِلَهٌ وَفِي الأَرْضِ إِلَهٌ [الزخرف: 84]\n" +
                                "ومعناه: ذو الألوهية التي لا تنبغي إلا له, ومعنى أله يأله إلهة عبد يعبد عبادة، فالله المألوه أي المعبود ولهذا الاسم خصائص لا يحصيها إلا الله عز وجل, وقيل إنه هو الاسم الأعظم (2)\n" +
                                "وهو علم على ذاته تبارك وتعالى وكل الأسماء الحسنى تضاف إليه كما قال تعالى: وَلِلّهِ الأَسْمَآءُ الْحُسْنَى [الأعراف:180] وقال تعالى: اللَّهُ لا إِلَهَ إِلا هُوَ لَهُ الأَسْمَاءُ الْحُسْنَى [طه:8] ألا ترى أنك تقول الرحمن من أسماء الله تعالى والرحيم من أسماء الله ونحو ذلك, ولا تقول الله من أسماء الرحمن, وقال النبي: ((إن لله تسعة وتسعين اسما مائة إلا واحدا من أحصاها دخل الجنة)) (1) واختلفوا في كونه مشتقا أو لا, ذهب الخليل وسيبويه وجماعة من أئمة اللغة والشافعي والخطابي وإمام الحرمين ومن وافقهم إلى عدم اشتقاقه لأن الألف واللام فيه لازمة فتقول يا الله ولا تقول يا الرحمن, فلولا أنه من أصل الكلمة لما جاز إدخال حرف النداء على الألف واللام وقال آخرون إنه مشتق (3)\n" +
                                "وقال السعدي: الإله هو الجامع لجميع صفات الكمال ونعوت الجلال، فقد دخل في هذا الاسم جميع الأسماء الحسنى، ولهذا كان القول الصحيح إن الله أصله الإله وأن اسم الله هو الجامع لجميع الأسماء الحسنى والصفات العلى";
                        break;
                    case "الرحمن":
                        description = "قال تعالى: وَإِلَهُكُمْ إِلَهٌ وَاحِدٌ لَا إِلَهَ إِلَّا هُوَ الرَّحْمَنُ الرَّحِيمُ [البقرة: 163].\n" +
                                " (الرحمن الرحيم) اسمان مشتقان من الرحمة على وجه المبالغة, ورحمن أشد مبالغة من رحيم فالرحمن يدل على الرحمة العامة كما قال تعالى: الرَّحْمَنُ عَلَى الْعَرْشِ اسْتَوَى [طه: 5] والرحيم يدل على الرحمة الخاصة بالمؤمنين كما قال تعالى: وَكَانَ بِالْمُؤْمِنِينَ رَحِيمًا [الأحزاب:47] ذكره ابن جرير بسنده عن العزرمي بمعناه وفي الدعاء المأثور ((رحمن الدنيا والآخرة ورحيمهما)) (1) , والظاهر المفهوم من نصوص الكتاب والسنة أن اسمه الرحمن يدل على الصفة الذاتية من حيث اتصافه تعالى بالرحمة, واسمه الرحيم يدل على الصفة الفعلية من حيث إيصاله الرحمة إلى المرحوم, فلهذا قال تعالى: وَكَانَ بِالْمُؤْمِنِينَ رَحِيمًا [الأحزاب:43] إِنَّهُ بِهِمْ رَؤُوفٌ رَّحِيمٌ [التوبة:117] ولم يأت قط إنه بهم رحمن, ووصف نبيه محمداً صلى الله عليه وسلم بأنه رؤوف رحيم فقال تعالى: حَرِيصٌ عَلَيْكُم بِالْمُؤْمِنِينَ رَؤُوفٌ رَّحِيمٌ [التوبة:128] ولم يصف أحدا من خلقه أنه رحمن فتأمل ذلك, والله أعلم";

                        break;

                    default:
                        description = "";
                }
                showAlertDialog(name, description);
            }
        });
    }

    private void showAlertDialog(String name, String description){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(name);
        builder.setMessage(description);
        builder.setPositiveButton("الحمد لله", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //finish();
                dialogInterface.dismiss();
            }
        });
        builder.create().show();

    }
    }

